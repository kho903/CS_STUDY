package com.company.design.facade;

public class Writer {
    private String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect() {
        String msg = String.format("Write %s로 연결합니다.", fileName);
        System.out.println(msg);
    }

    public void fileDisconnect() {
        String msg = String.format("Write %s로의 연결을 종료합니다.", fileName);
        System.out.println(msg);
    }

    public void  write() {
        String msg = String.format("Write %s로 파일쓰기를 합니다.", fileName);
        System.out.println(msg);
    }
}
