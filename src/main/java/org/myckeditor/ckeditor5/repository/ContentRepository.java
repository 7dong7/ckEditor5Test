package org.myckeditor.ckeditor5.repository;

import org.myckeditor.ckeditor5.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<ContentEntity, Integer> {

}
