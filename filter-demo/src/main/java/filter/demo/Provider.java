package filter.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Provider {

    private String source;
    private String url;
    private LocalDateTime pubDate;

}
