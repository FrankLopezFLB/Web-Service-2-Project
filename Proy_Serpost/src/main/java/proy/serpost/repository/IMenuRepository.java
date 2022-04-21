package proy.serpost.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import proy.serpost.model.Menu;
@Repository
public interface IMenuRepository extends JpaRepository<Menu,Integer> {
	@Query(value = "select a.COD_MENU,m.DESC_MENU,m.URL_MENU from ACCESO a join MENU m on a.COD_MENU=m.COD_MENU where TRA_CODIGO=?1", nativeQuery = true)
	List<Menu> spMenu(int codtraba);
}
