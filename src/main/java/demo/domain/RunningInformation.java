package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*; //for OR mapping
import java.util.Date;
import java.util.Random;

//h2 database doesn't need to configure, JPA will create table with all the fields

@Data
@Entity //annotate as an entity class // not use Entity from hibernate b/c hibernate is JPA provider; better use standard
@Table(name = "RUNNING_ANALYSIS") // if not annotate, by default the table name is the same as class name
// Json serialization/deserialization use Jackson library
// separate frontend and backend, use rest API to communicate
// frontend send JSON format, while java is object model, use OR mapping to map with relational model
// use jackson to change json string to java object
@JsonInclude(JsonInclude.Include.NON_NULL) // include some fields
public class RunningInformation {

    public enum HealthWarningLevel {
        LOW, NORMAL, HIGH, ABNORMAL;
        public static HealthWarningLevel getHealthWarningLevel(int heartRate) {
            if (heartRate >= 60 && heartRate <= 75){
                return HealthWarningLevel.LOW;
            }
            else if (heartRate > 75 && heartRate <= 120) {
                return HealthWarningLevel.NORMAL;
            }
            else if (heartRate > 120) {
                return HealthWarningLevel.HIGH;
            }
            else {
                return HealthWarningLevel.ABNORMAL;
            }
        }
    }

    @Id
    @GeneratedValue // could be generated automatically
    private Long id;
    private String runningId;

    //@Column(name = "LAT") by deault the same
    private Double latitude;
    private Double longitude;
    private Double runningDistance;
    private Double totalRunningTime;
    private int heartRate;
    private Date Timestamp = new Date();

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "userName")),
            @AttributeOverride(name = "address", column = @Column(name = "userAddress"))
    })
    private UserInfo userInfo;
    private HealthWarningLevel healthWarningLevel;

    public RunningInformation() {
        this.userInfo = null;
    }

    @JsonCreator // called when do json seri/deseri
    public RunningInformation(@JsonProperty("userInfo") UserInfo userInfo) {
        this.userInfo = userInfo;
        this.heartRate = getRandomHeartBeat();
    }



    private int getRandomHeartBeat() {
        Random random = new Random();
        return random.nextInt(141) + 60;
    }
}
