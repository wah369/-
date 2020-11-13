package compare;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-10
 * Time: 10:57
 */
import java.util.Comparator;

public class ScoreCompartor implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.score-o2.score;
    }
}
