package filter.demo;

import com.vaadin.flow.component.polymertemplate.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Model {

    private List<Player> data;
    private int ttl;
    private boolean cache3;
    private String v;
    //private Provider provider;
    private int creditsLeft;
}
