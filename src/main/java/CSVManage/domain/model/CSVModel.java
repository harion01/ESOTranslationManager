package CSVManage.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class CSVModel {
    String uniqueId;
    int category;
    int sub;
    int index;
    String source;
    String target;

    public CSVModel(String id, String source, String target){
        this.uniqueId = id;
        this.source = source;
        this.target = target;

        String[] ids = id.split("-");
        this.category = Integer.parseInt(ids[0]);
        this.sub = Integer.parseInt(ids[1]);
        this.index = Integer.parseInt(ids[2]);
    }

    public CSVModel(CSVModel copyTarget){
        this.uniqueId = copyTarget.getUniqueId();
        this.source = copyTarget.getSource();
        this.target = copyTarget.getTarget();

        this.category = copyTarget.getCategory();
        this.sub = copyTarget.getSub();
        this.index = copyTarget.getIndex();
    }
}
