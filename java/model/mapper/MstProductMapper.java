package jp.co.internous.bloom.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.bloom.model.domain.MstProduct;

@Mapper
public interface MstProductMapper {
	
	@Select("SELECT * FROM mst_product")
	List<MstProduct> findAll();
	//全商品表示
	
	
	List<MstProduct> findByCategoryIdAndProductName(
			@Param("categoryId") int categoryId,
			@Param("searchWords") String[] searchWords);
	//カテゴリと商品名で検索 検索ワードを配列に格納
	
	List<MstProduct> findByProductName(@Param("searchWords") String[] searchWords);
	//商品名で検索　検索ワードを配列に格納
	
}
