package jp.co.internous.bloom.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.bloom.model.domain.MstCategory;

@Mapper
public interface MstCategoryMapper {
	
	@Select("SELECT * FROM mst_category")
	List<MstCategory> findAll();
	//mst_categoryテーブル全抽出

}
