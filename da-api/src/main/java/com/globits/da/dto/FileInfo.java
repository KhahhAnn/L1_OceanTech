package com.globits.da.dto;


public class FileInfo {
    private String fileName;
    private Long fileLength;
    private String contentType;
    private Boolean readable;
    private Boolean isFileEmpty;
    private byte[] fileData;

    public FileInfo() {
    }

    public FileInfo(String fileName, Long fileLength, String contentType, Boolean readable, Boolean isFileEmpty, byte[] fileData) {
        this.fileName = fileName;
        this.fileLength = fileLength;
        this.contentType = contentType;
        this.readable = readable;
        this.isFileEmpty = isFileEmpty;
        this.fileData = fileData;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileLength() {
        return fileLength;
    }

    public void setFileLength(Long fileLength) {
        this.fileLength = fileLength;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Boolean getReadable() {
        return readable;
    }

    public void setReadable(Boolean readable) {
        this.readable = readable;
    }

    public Boolean getFileEmpty() {
        return isFileEmpty;
    }

    public void setFileEmpty(Boolean fileEmpty) {
        isFileEmpty = fileEmpty;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}
