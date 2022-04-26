package jp.co.internous.bloom.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.bloom.model.domain.MstCategory;
import jp.co.internous.bloom.model.domain.MstProduct;
import jp.co.internous.bloom.model.form.SearchForm;
import jp.co.internous.bloom.model.mapper.MstCategoryMapper;
import jp.co.internous.bloom.model.mapper.MstProductMapper;
import jp.co.internous.bloom.model.session.LoginSession;

@Controller
@RequestMapping("/bloom")
public class IndexController {
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private MstCategoryMapper categoryMapper;
	
	@Autowired
	private MstProductMapper productMapper;
	
	
	@RequestMapping("/")
	public String index(Model m) {
		
		if(!loginSession.isLogined() && loginSession.getTmpUserId() == 0){
			//ログインしていないかつ仮ユーザーIDがない場合、仮ユーザーID作成
			
			Random r = new Random();
			int num = r.nextInt(900000000) + 100000000; //9桁の乱数
			int tId = num * (-1); //負の整数に変換
			loginSession.setTmpUserId(tId); //loginSessionへ代入
		}
		
		List<MstCategory> categories = categoryMapper.findAll();
		
		List<MstProduct> product = productMapper.findAll();

		
		m.addAttribute("categories", categories);
		//categoryNameとcategoryIdをcategoriesで呼び出せるようにする
		
		m.addAttribute("product", product);
		//カテゴリーなし && 商品検索入力なし
		
		m.addAttribute("selected", 0);
		//カテゴリー選択しない場合の0を送る
		
		m.addAttribute("loginSession", loginSession);
		//page_header.htmlでsessionの変数を表示させているためloginSessionも送る
		
		return "index";
	}
	
	
	@RequestMapping("/searchItem")
	public String serchItem(
			SearchForm f,
			Model m) {
		
		List<MstProduct> product = null;

		String searchWords = f.getSearhWords().replaceAll("　", " ").replaceAll("\\s{2,}", " ").trim();
		//全角スペースを半角スペースに変換・2つ以上続いている半角スペースを1つに変換・行頭行末のスペースを削除	

		
		if(f.getCategoryId() == 0) { //カテゴリー未選択の場合、検索ワードで抽出
				
			product = productMapper.findByProductName(searchWords.split(" "));
			
		} else { //カテゴリー選択ありの場合、検索ワードでとカテゴリーで抽出
			
			product = productMapper.findByCategoryIdAndProductName(f.getCategoryId(), searchWords.split(" "));
		}
		
		List<MstCategory> categories = categoryMapper.findAll();
		
		m.addAttribute("searchWords", searchWords);
		//検索した文字列を表示させるため送る
		
		m.addAttribute("selected", f.getCategoryId()); 
		//検索したカテゴリーを表示させるため送る
		
		m.addAttribute("categories", categories);
		//カテゴリー名を表示させるため送る
		
		m.addAttribute("product", product);
		//検索してヒットした商品を表示させるため送る
		
		m.addAttribute("loginSession", loginSession);
		//page_header.htmlでsessionの変数を表示させているため、loginSessionも送る
		
		return "index";
	}
}
