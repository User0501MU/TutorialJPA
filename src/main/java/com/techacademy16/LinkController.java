package com.techacademy16;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class LinkController {
	// 詳細画面に遷移するリンク--URLリンク式 課題追記部分
	//リクエストマッピングのパスを一意にする: もし、同じパスを使用したい場合は、★メソッド間で異なるHTTPメソッドを使うか、クエリパラメータを使用して異なる振る舞いをするようにします。
	@GetMapping("/detail")
    public String getLink(Model model) {
        model.addAttribute("id", "123");
        return "detail";//datail.html画面遷移
	}
}
