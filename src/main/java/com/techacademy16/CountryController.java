//コントローラー作成4.6
package com.techacademy16;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PathVariable; // 追加
import org.springframework.web.bind.annotation.PostMapping; // 追加
import org.springframework.web.bind.annotation.RequestParam; // 追加

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

	//?詳細URLリンク式 課題追記部分
		//リクエストマッピングのパスを一意にする: もし、同じパスを使用したい場合は、★メソッド間で異なるHTTPメソッドを使うか、クエリパラメータを使用して異なる振る舞いをするようにします。
		@GetMapping("/detail")
	    public String getLink(Model model) {
	        model.addAttribute("id", "123");
	        return "detail";//datail.html画面遷移
		}


		 // ----- 追加:ここから -----
	    // ----- 詳細画面 -----
	    @GetMapping(value = { "/detail", "/detail/{code}/" })
	    public String getCountry(@PathVariable(name = "code", required = false) String code, Model model) {
	        // codeが指定されていたら検索結果、無ければ空のクラスを設定
	        Country country = code != null ? service.getCountry(code) : new Country();
	        // Modelに登録
	        model.addAttribute("country", country);
	        // country/detail.htmlに画面遷移
	        return "country/detail";
	    }

	    // ----- 更新（追加） -----
	    @PostMapping("/detail")
	    public String postCountry(@RequestParam("code") String code, @RequestParam("name") String name,
	            @RequestParam("population") int population, Model model) {
	        // 更新（追加）
	        service.updateCountry(code, name, population);

	        // 一覧画面にリダイレクト
	        return "redirect:/country/list";
	    }

	    // ----- 削除画面 -----
	    @GetMapping("/delete")
	    public String deleteCountryForm(Model model) {
	        return "country/delete";// country/delete.htmlに画面遷移
	    }

	    //? 削除リンク式　課題部分
	    @GetMapping("/delete")
	    public String getLink1(Model model) {
	        model.addAttribute("id", "123");
	        return "delete";//delete.html画面遷移
		}

	    // ----- 削除 -----
	    @PostMapping("/delete")
	    public String deleteCountry(@RequestParam("code") String code, Model model) {
	        // 削除
	        service.deleteCountry(code);

	        // 一覧画面にリダイレクト
	        return "redirect:/country/list";
	    }
	    // ----- 追加:ここまで -----

	    //一覧に戻る画面遷移 クエリパラメータの取得 変数param




	}

