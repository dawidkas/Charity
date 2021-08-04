package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.Donation;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    Donation findById(long id);
    Donation findByCity(String street);
    Donation findByZipCode(String zipCode);

    @Query(value = "SELECT COALESCE (SUM(d.quantity), 0) FROM Donation d")
    Integer getBagsTotalQuantity();

    @Query(value = "SELECT count (d.id) FROM Donation d")
    Integer getDonationCount();
}