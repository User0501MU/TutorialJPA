//コントローラー作成4.6
package com.techacademy16;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("country")
public class CountryController {
	private final CountryService service;

	public CountryController(CountryService service) {
		this.service = service;
	}

	// ----- 一覧画面 -----
	@GetMapping("/list")
	public String getList(Model model) {
		// 全件検索結果をModelに登録
		model.addAttribute("countrylist", service.getCountryList());
		// country/list.htmlに画面遷移
		return "country/list";
	}

	// 詳細画面に遷移するリンク--URLリンク式 課題追記部分
		//リクエストマッピングのパスを一意にする: もし、同じパスを使用したい場合は、★メソッド間で異なるHTTPメソッドを使うか、クエリパラメータを使用して異なる振る舞いをするようにします。
		@GetMapping("/detail")
	    public String getLink(Model model) {
	        model.addAttribute("id", "123");
	        return "detail";//datail.html画面遷移
		}
}