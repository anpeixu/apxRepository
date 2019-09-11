package com.leyou.upload.Service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UploadService {
    private  static  final List<String>  ALLOWTYPE= Arrays.asList("image/jpeg","image/png","image/bmp");
    public String uploadImage(MultipartFile file) {
        try {
            //校验文件类型
            String type = file.getContentType();
            if (!ALLOWTYPE.contains(type)){
                throw  new LyException(ExceptionEnum.INVALID_FILE_TYPER);
            }
            //校验文件内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if(image==null){
                throw  new LyException(ExceptionEnum.INVALID_FILE_TYPER);
            }
            //准备目标路径
        File dest=new File("D:\\git_work\\apxRepository\\ly-upload\\src\\main\\resources\\img",file.getOriginalFilename());
        //保存本地文件
            file.transferTo(dest);
            return "http://image.leyou.com/"+file.getOriginalFilename();
        } catch (IOException e) {
            log.error("上传文件失败！"+e);
            throw new LyException(ExceptionEnum.UPLOAD_FILE_ERROR);
        }
        //返回路径


    }
}
