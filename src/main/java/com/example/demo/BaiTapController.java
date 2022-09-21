package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BaiTapController {
    @GetMapping("bai1")
    public String bai1(@RequestParam(name = "str1") String str1,
                       @RequestParam(name = "str2") String str2,
                       Model model) {
        StringBuilder hienThi = new StringBuilder();
        if (str1.length() > str2.length()) {
            hienThi.append(str1);
        } else if (str1.length() < str2.length()) {
            hienThi.append(str2);
        } else {
            hienThi.append("2 chuỗi bằng nhau");
        }
        model.addAttribute("hienThi", hienThi.toString());
        return "bai1";
    }

    @GetMapping("bai2")
    public String bai2(@RequestParam(name = "str") StringBuilder str,
                       Model model) {
        model.addAttribute("hienThi", str.reverse().toString());
        return "bai2";
    }

    @GetMapping("bai3")
    public String bai3(@RequestParam(name = "number") Integer number,
                       Model model) {
        if (number < 2) model.addAttribute("nguyenTo", 2);
        else {
            int a = number + 1;
            while (!kiemTra(a)) {
                a++;
            }
            model.addAttribute("hienThi", a);
        }
        return "bai3";
    }

    private Boolean kiemTra(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
