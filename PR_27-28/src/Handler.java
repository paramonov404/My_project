import java.util.ArrayList;

public class Handler {

    @TaskAnnotation
    public void sum(Data data)
    {
        int result = 0;
        for(Integer value : data.getNumbers())
        {
            result += value;
        }
        System.out.println(result);
    }

    @TaskAnnotation
    public void print(Data data)
    {
        for(int i = 0; i < data.getWords().size(); i++)
        {
            System.out.print(data.getWords().get(i));
            if(i != data.getWords().size() - 1)
                System.out.print(data.getDelimeter());
        }
    }
}