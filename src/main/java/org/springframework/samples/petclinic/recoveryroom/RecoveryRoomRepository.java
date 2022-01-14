package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
    List<RecoveryRoom> findAll();
    @Query("SELECT roomtype FROM RecoveryRoomType roomtype ORDER BY roomtype.name")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);
    @Query("SELECT rtype FROM RecoveryRoomType rtype WHERE rtype.name LIKE :name%")
    RecoveryRoomType getRecoveryRoomType(String name);
    @Query("SELECT r FROM RecoveryRoom r WHERE r.size> :size")
    List<RecoveryRoom> findBySizeMoreThan(double size);
}
