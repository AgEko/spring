package tekcamp.mod12.spring.exercise.DAOrepository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tekcamp.mod12.spring.exercise.Model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, PagingAndSortingRepository<User, Long> {
    User findByUserId(Long id);
    User findByEmailAddress(String email);

}
