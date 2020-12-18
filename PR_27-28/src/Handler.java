import java.util.ArrayList;

public class Handler {

    @TaskAnnotation(type = "sum")
    public void sum(Data data)
    {
        int result = 0;
        for(Integer value : data.getNumbers())
        {
            result += value;
        }
        System.out.println(result);
    }

    @TaskAnnotation(type = "print")
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