package demo.service;

import demo.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RunningInformationService {

    // save running information
    List<RunningInformation> saveRunningInformations(List<RunningInformation> runningInformations);

    // delete all
    void deleteAll();

    // find
    RunningInformation findByRunningId(String runningId);
    Page<RunningInformation> findByUserInfoUsernameOrderByHealthWarningLevelDesc(String username, Pageable pageable);

}


// why use interface? can have different implementation;
// now we use repository, later we could use others like web service to implement, more flexible