package com.eomcs.io.ex06;

import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedFileOutputStream extends FileOutputStream {
  byte[] buf = new byte[8192];
  int cursor;

  public BufferedFileOutputStream(String filename) throws Exception {
    super(filename);
  }

  @Override
  public void write(int b) throws IOException {
    if (cursor == buf.length) { // 버퍼가 다차면
      super.write(buf); // 버퍼에 들어있는 데이터를 한 번에 출력한다.
      cursor = 0; // 다시 커서를 초기화시킨다.
    }

    // 1바이트 출력하라고 하면 일단 버퍼에 저장할 것이다.
    buf[cursor++] = (byte) b;
  }

  @Override
  public void write(byte[] buf) throws IOException {
    for (byte b : buf) {
      this.write(b & 0x000000ff);
    }
  }


  @Override
  public void close() throws IOException {
    this.flush();  // 버퍼의 남아있는 가비지를 출력한다.
    super.close();
  }


  @Override
  public void flush() throws IOException {
    if (cursor > 0) {  // 어찌됐든 커서가 0보다 크면
      this.write(buf, 0, cursor);  // 남아있는 가비지를  출력한다.
      cursor = 0;
    }
  }

}


