package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//枚举 是具有固定实例个数的类
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    PRICE_CANNOT_BE_NULL(400,"价格不能为空！"),
    CATEGORY_NOT_FOND(400,"商品分类没查到！"),
    BRAND_NOT_FOND(404,"品牌没有查询到！"),
    BRAND_SAVE_ERROR(500,"新增品牌失败 ！"),
    UPLOAD_FILE_ERROR(500,"上传失败 ！"),
    INVALID_FILE_TYPER(500,"无效文件类型 ！");
   ;
   private int code;
   private String msg;
}
