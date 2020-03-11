//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.snackpub.core.boot.file;

import java.io.File;

public class FileProxyManager {
    private IFileProxy defaultFileProxyFactory = new RisesinFileProxyFactory();
    private static FileProxyManager me = new FileProxyManager();

    public FileProxyManager() {
    }

    public static FileProxyManager me() {
        return me;
    }

    public IFileProxy getDefaultFileProxyFactory() {
        return this.defaultFileProxyFactory;
    }

    public void setDefaultFileProxyFactory(IFileProxy defaultFileProxyFactory) {
        this.defaultFileProxyFactory = defaultFileProxyFactory;
    }

    public String[] path(File file, String dir) {
        return this.defaultFileProxyFactory.path(file, dir);
    }

    public File rename(File file, String path) {
        return this.defaultFileProxyFactory.rename(file, path);
    }
}
