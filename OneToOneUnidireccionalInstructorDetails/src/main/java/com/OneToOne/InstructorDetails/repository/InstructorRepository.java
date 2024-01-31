package com.OneToOne.InstructorDetails.repository;

import com.OneToOne.InstructorDetails.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
