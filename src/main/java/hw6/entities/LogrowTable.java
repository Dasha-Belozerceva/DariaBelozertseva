package hw6.entities;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class LogrowTable {
    private String logrowValue;
    private String logrowCondition;

    public LogrowTable(String logrowValue, String logrowCondition){
        this.logrowValue = logrowValue;
        this.logrowCondition = logrowCondition;
    }
}
