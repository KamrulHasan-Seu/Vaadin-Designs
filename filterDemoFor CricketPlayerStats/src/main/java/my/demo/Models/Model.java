package my.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Model {
    private int pid;
    private String fullName;
    private String name;
    private String details;
    private String imageUrl;
    private String batStyle;
    private String bowlStyle;
    private String playForTeams;
    private String age;
    private String Country;
    private String playingRole;
    private List<Performance> performanceList;
    private int ttl;
    private Provider provider;
    private int creditsLeft;
}
