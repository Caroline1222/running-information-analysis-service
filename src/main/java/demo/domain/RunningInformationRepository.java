package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

// extends JpaRepository, has two args, entity type and id type
@RepositoryRestResource(path = "runninginfo")
public interface RunningInformationRepository extends JpaRepository<RunningInformation, Long> {
    // Pageable is paging parameter
    @RestResource(path = "runningid")
    RunningInformation findByRunningId(@Param("runningId") String runningId);
    @RestResource(path = "username")
    Page<RunningInformation> findByUserInfoUsernameOrderByHealthWarningLevelDesc(@Param("username") String username, Pageable pageable);


}

// java doesn't support multiple inheritance
// spring data is abstraction data access
// spring data supports paging
// Why JpaRepository? provides common data access methods(save, update, delete, find)
