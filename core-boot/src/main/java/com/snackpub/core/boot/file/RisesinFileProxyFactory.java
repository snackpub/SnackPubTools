//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.snackpub.core.boot.file;

import com.snackpub.core.tools.constant.SystemConstant;
import com.snackpub.core.tools.utils.DateUtil;
import com.snackpub.core.tools.utils.ImageUtil;
import com.snackpub.core.tools.utils.StringPool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * 文件代理类
 *
 * @author Chill
 */
public class RisesinFileProxyFactory implements IFileProxy {
    @Override
    public File rename(File f, String path) {
        File dest = new File(path);
        f.renameTo(dest);
        return dest;
    }

    @Override
    public String[] path(File f, String dir) {
        //避免网络延迟导致时间不同步
        long time = System.nanoTime();

        StringBuilder uploadPath = new StringBuilder()
                .append(getFileDir(dir, SystemConstant.me().getUploadRealPath()))
                .append(time)
                .append(getFileExt(f.getName()));

        StringBuilder virtualPath = new StringBuilder()
                .append(getFileDir(dir, SystemConstant.me().getUploadCtxPath()))
                .append(time)
                .append(getFileExt(f.getName()));

        return new String[]{RisesinFileUtil.formatUrl(uploadPath.toString()), RisesinFileUtil.formatUrl(virtualPath.toString())};
    }

    /**
     * 获取文件后缀
     *
     * @param fileName 文件名
     * @return 文件后缀
     */
    public static String getFileExt(String fileName) {
        if (!fileName.contains(StringPool.DOT)) {
            return ".jpg";
        } else {
            return fileName.substring(fileName.lastIndexOf(StringPool.DOT));
        }
    }

    /**
     * 获取文件保存地址
     *
     * @param dir     目录
     * @param saveDir 保存目录
     * @return 地址
     */
    public static String getFileDir(String dir, String saveDir) {
        StringBuilder newFileDir = new StringBuilder();
        newFileDir.append(saveDir)
                .append(File.separator).append(dir).append(File.separator).append(DateUtil.format(new Date(), "yyyyMMdd"))
                .append(File.separator);
        return newFileDir.toString();
    }


    /**
     * 图片压缩
     *
     * @param path 文件地址
     */
    @Override
    public void compress(String path) {
        try {
            ImageUtil.zoomScale(ImageUtil.readImage(path), new FileOutputStream(new File(path)), null, SystemConstant.me().getCompressScale(), SystemConstant.me().isCompressFlag());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
