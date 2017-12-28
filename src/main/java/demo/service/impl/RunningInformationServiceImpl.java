package demo.service.impl;

import demo.domain.RunningInformation;
import demo.domain.RunningInformationRepository;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // annotate it as a service bean
public class RunningInformationServiceImpl implements RunningInformationService{


    // to implement save, we need to impl save in RunningInfoRepo, but don't have, can impl save in JpaRepo
    // in RunningInfoRepo, we don't need to write impl, Jpa will generate when run


    private RunningInformationRepository runningInformationRepository;

    @Autowired // constructor dependency injection recommened
    // we need use runningInfoRepo inside this impl class, autowire help us find it and import it
    // as for how runningInfoRepo is implemented and initiated, we don't care here
    public RunningInformationServiceImpl(RunningInformationRepository runningInformationRepository){
        this.runningInformationRepository = runningInformationRepository;
    }



    @Override
    public List<RunningInformation> saveRunningInformations(List<RunningInformation> runningInformations) {
        return runningInformationRepository.save(runningInformations);
    }

    @Override
    public void deleteAll() {
        runningInformationRepository.deleteAll();
    }

    @Override
    public RunningInformation findByRunningId(String runningId) {
        return runningInformationRepository.findByRunningId(runningId);
    }

    @Override
    public Page<RunningInformation> findByUserInfoUsernameOrderByHealthWarningLevelDesc(String username, Pageable pageable) {
        return runningInformationRepository.findByUserInfoUsernameOrderByHealthWarningLevelDesc(username, pageable);
    }
}

// dependency injection
