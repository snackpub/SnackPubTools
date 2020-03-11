package com.snackpub.core.boot.ctrl;

import com.snackpub.core.boot.file.RisesinFile;
import com.snackpub.core.boot.file.RisesinFileUtil;
import com.snackpub.core.secure.BladeUser;
import com.snackpub.core.secure.utils.SecureUtil;
import com.snackpub.core.tools.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Risesin控制器封装类
 */
public class BladeController {
    /**
     * ============================     REQUEST    =================================================
     */
    @Autowired
    private HttpServletRequest request;

    /**
     * 获取request
     *
     * @return HttpServletRequest
     */
    public HttpServletRequest getRequest() {
        return this.request;
    }

    /**
     * 获取当前用户
     *
     * @return BladeUser
     */
    public BladeUser getUser() {
        return SecureUtil.getUser();
    }

    /** ============================     API_RESULT    =================================================  */

    /**
     * 返回ApiResult
     *
     * @param data 数据
     * @param <T>  T 泛型标记
     * @return R
     */
    public <T> R<T> data(T data) {
        return R.data(data);
    }

    /**
     * 返回ApiResult
     *
     * @param data 数据
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public <T> R<T> data(T data, String msg) {
        return R.data(data, msg);
    }

    /**
     * 返回ApiResult
     *
     * @param data 数据
     * @param msg  消息
     * @param code 状态码
     * @param <T>  T 泛型标记
     * @return R
     */
    public <T> R<T> data(T data, String msg, int code) {
        return R.data(code, data, msg);
    }

    /**
     * 返回ApiResult
     *
     * @param msg 消息
     * @return R
     */
    public R success(String msg) {
        return R.success(msg);
    }

    /**
     * 返回ApiResult
     *
     * @param msg 消息
     * @return R
     */
    public R fail(String msg) {
        return R.fail(msg);
    }

    /**
     * 返回ApiResult
     *
     * @param flag 是否成功
     * @return R
     */
    public R status(boolean flag) {
        return R.status(flag);
    }

    /**============================     FILE    =================================================  */

    /**
     * 获取RisesinFile封装类
     *
     * @param file 文件
     * @return RisesinFile
     */
    public RisesinFile getFile(MultipartFile file) {
        return RisesinFileUtil.getFile(file);
    }

    /**
     * 获取RisesinFile封装类
     *
     * @param file 文件
     * @param dir  目录
     * @return RisesinFile
     */
    public RisesinFile getFile(MultipartFile file, String dir) {
        return RisesinFileUtil.getFile(file, dir);
    }

    /**
     * 获取RisesinFile封装类
     *
     * @param file        文件
     * @param dir         目录
     * @param path        路径
     * @param virtualPath 虚拟路径
     * @return RisesinFile
     */
    public RisesinFile getFile(MultipartFile file, String dir, String path, String virtualPath) {
        return RisesinFileUtil.getFile(file, dir, path, virtualPath);
    }

    /**
     * 获取RisesinFile封装类
     *
     * @param files 文件集合
     * @return RisesinFile
     */
    public List<RisesinFile> getFiles(List<MultipartFile> files) {
        return RisesinFileUtil.getFiles(files);
    }

    /**
     * 获取RisesinFile封装类
     *
     * @param files 文件集合
     * @param dir   目录
     * @return RisesinFile
     */
    public List<RisesinFile> getFiles(List<MultipartFile> files, String dir) {
        return RisesinFileUtil.getFiles(files, dir);
    }

    /**
     * 获取RisesinFile封装类
     *
     * @param files       文件集合
     * @param dir         目录
     * @param virtualPath 虚拟路径
     * @return RisesinFile
     */
    public List<RisesinFile> getFiles(List<MultipartFile> files, String dir, String path, String virtualPath) {
        return RisesinFileUtil.getFiles(files, dir, path, virtualPath);
    }
}
