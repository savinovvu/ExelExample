package ru.inbox.savinov_vu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.Contractor;

import java.util.UUID;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, UUID> {
}
