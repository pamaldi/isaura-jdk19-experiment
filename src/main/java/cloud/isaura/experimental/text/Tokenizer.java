package cloud.isaura.experimental.text;




import io.reactivex.rxjava3.core.Scheduler;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tokenizer
{


    private HashMap<String, Integer> tokens;
    private Channel<String> resourceReaderChannel;

    private Channel<Boolean>[] closeChannels;

    private LineByLineReader lineByLineReader;

    private List<TokenWorker> workers;

    public Tokenizer()
    {
        this.tokens = new HashMap<>();
        this.resourceReaderChannel = new Channel<>();


    }

    public void tokens(TokenizerOption tokenizerOption) throws IOException, URISyntaxException
    {
       TokenizerParamsValidator tokenizerParamsValidator = new TokenizerParamsValidator();
       tokenizerParamsValidator.isValid(tokenizerOption);
       this.lineByLineReader = new LineByLineReader(tokenizerOption.fileName(),resourceReaderChannel) ;
       lineByLineReader.start();
       this.workers = new ArrayList<>(tokenizerOption.numberOfReader());
       IntStream.range(0,tokenizerOption.numberOfReader())
               .forEach(
                       integer ->
                       {
                           TokenWorker tokenWorker = new TokenWorker(resourceReaderChannel);
                           this.workers.add(tokenWorker);
                           tokenWorker.start();
                       }
               );
       while(true)
       {
          // System.out.println("waiting");
       }

       /*
       this.lineByLineReaders = new ArrayList<>(tokenizerOption.numberOfReader());
       String resourcePath = FileUtils.getResourcePath();
        long start = System.currentTimeMillis();
        List<File> files = FileSplitter.splitBySize(tokenizerOption.is(), tokenizerOption.numberOfReader(), resourcePath);
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println(" elapsed split "+diff);
        this.closeChannels = new Channel[tokenizerOption.numberOfReader()];

       for(int i = 0; i < files.size(); i++)
       {

           File file = files.get(i);
           this.closeChannels[i] = new Channel<>();
           this.closeChannels[i].put(Boolean.FALSE);
           LineByLineReader lineByLineReader = new LineByLineReader(file.getAbsolutePath(), channel, this.closeChannels[i]);
           this.lineByLineReaders.add(lineByLineReader);

       }

        Thread.startVirtualThread(this::run);
        this.lineByLineReaders.forEach(LineByLineReader::start);


        */



    }



    public Integer numberOfTokens()
    {
        return this.tokens.size();
    }

}
