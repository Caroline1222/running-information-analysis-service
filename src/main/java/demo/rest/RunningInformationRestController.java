package demo.rest;


import demo.domain.RunningInformation;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunningInformationRestController {
    private RunningInformationService runningInformationService;

    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_SIZE = 2;

    @Autowired //dependency injection
    public RunningInformationRestController(RunningInformationService runningInformationService){
        this.runningInformationService = runningInformationService;
    }

    @RequestMapping(value = "/runningInfo", method = RequestMethod.POST)
    // value is like rest url
    // add new things use POST
    // if find, use GET
    @ResponseStatus(HttpStatus.CREATED) // 201; if doesn't write this sentence, use HttpStatus.OK by default, 200
    public void upload(@RequestBody List<RunningInformation> runningInformations){
        this.runningInformationService.saveRunningInformations(runningInformations);
    }

    @RequestMapping(value = "/runningInfo/purge", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void purge(){
        this.runningInformationService.deleteAll();
    }

    @RequestMapping(value = "/runningInfo/runningId/{runningId}", method = RequestMethod.GET)
    public RunningInformation findByRunningId(@PathVariable String runningId){
        return this.runningInformationService.findByRunningId(runningId);
    }

    @RequestMapping(value = "/runningInfo/username/{username}", method = RequestMethod.GET)
    public Page<RunningInformation> findByUserInfoUsernameOrderByHealthWarningLevelDesc(@PathVariable String username,
                                                                                        @PageableDefault(page = DEFAULT_PAGE_NUMBER, size = DEFAULT_PAGE_SIZE) Pageable pageable) {
        return this.runningInformationService.findByUserInfoUsernameOrderByHealthWarningLevelDesc(username, pageable);
    }

}
