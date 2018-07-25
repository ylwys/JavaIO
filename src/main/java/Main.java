import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: ylwys
 * Date: 13-2-28
 * Time: 上午10:24
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(111);

        // test11111
//        // -------------创建文件-------------------------------
//        String location = "F:" + File.separator + "yl.txt";
//        File file = new File(location);
//        try {
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//

//        //------------------删除文件------------------------------
//        String location = "F:" + File.separator + "yl.txt";
//        File file = new File(location);
//        try {
//            if (file.exists()) {
//                file.delete();
//            } else {
//                System.out.println("文件不存在");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        //------------------创建文件夹--------------------------------
//        String location = "F:" + File.separator + "Hello";
//        File file = new File(location);
//        file.mkdir();

//        //----------------删除文件夹(要文件夹里面为空时候)-------------------------------
//        String location = "F:" + File.separator + "Hello";
//        File file = new File(location);
//        if(file.isDirectory()){
//            file.delete();
//        }else{
//            System.out.print("不是文件夹");
//        }

//        //-----------------列出文件夹里的全部文件名------------------------
//        String location = "F:" + File.separator + "Hello";
//        File file = new File(location);
//        String[] containFiles = file.list();
//        for (String containFile : containFiles) {
//            System.out.println(containFile);
//        }

//        //------------------列出文件夹里的全部文件对象------------------------
//        String location = "F:" + File.separator + "Hello";
//        File file = new File(location);
//        if (file.isDirectory()) {
//            File[] containFiles = file.listFiles();
//            for (File containFile : containFiles) {
//                System.out.println(containFile);
//            }
//        } else {
//            System.out.println("不是目录");
//        }

//        //--------------用RandomAccessFile写入文件（是乱码）----------------------------
//        String location = "F:" + File.separator + "yl.txt";
//        File file = new File(location);
//        try {
//            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
//            randomAccessFile.writeBytes("asdsad");
//            randomAccessFile.writeInt(12);
//            randomAccessFile.writeBoolean(true);
//            randomAccessFile.writeChar('A');
//            randomAccessFile.writeFloat(1.21f);
//            randomAccessFile.writeDouble(12.123);
//            randomAccessFile.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        //-----------------FileOutputStream文件字节流往文件里写东西---------------------------
//        String location = "F:" + File.separator + "yl.txt";
//        File file = new File(location);
//        String s = "阿斯蒂芬";
//        byte[] bytes = s.getBytes();
//        try {
//            OutputStream fileOutputStream = new FileOutputStream(file, true);//为true时不是追加，默认false为覆盖
//            fileOutputStream.write(bytes);//直接写byte[]数组
//            for (byte b : bytes) { //或者在循环里一个一个写byte
//                fileOutputStream.write(b);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        //------------------FileInputStream读取文件里的内容----------------------------------
//        String location = "F:" + File.separator + "yl.txt";
//        File file = new File(location);
//        byte[] bytes = new byte[(int) (file.length())];
//        try {
//            InputStream inputStream = new FileInputStream(file);
//            inputStream.read(bytes);
//            System.out.println(new String(bytes));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        //-----------------字符流往文件里写东西-----------------------------------------
//        String location = "F:" + File.separator + "test.txt";
//        File file = new File(location);
//        String s = "阿萨德\r\n发送";
//        try {
//            Writer writer = new FileWriter(file);
//            writer.write(s);
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        //------------------从文件里读字符流---------------------------------
//        String location = "F:" + File.separator + "test.txt";
//        File file = new File(location);
//        char[] chars = new char[(int) file.length()];
//        try {
//            FileReader fileReader = new FileReader(file);
//            fileReader.read(chars);
//            System.out.println(new String(chars));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        //------------------字节流循环读在不知道文件大小情况小--------------------
//        String location = "F:" + File.separator + "test.txt";
//        File file = new File(location);
//        char[] chars = new char[1024];
//        int temp = 0;
//        int count = 0;
//        try {
//            FileReader fileReader = new FileReader(file);
//            while ((temp = fileReader.read()) != -1) {
//                chars[count++] = (char) temp;
//            }
//            System.out.println(new String(chars));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //#######字符流是在缓存区，而字节流是直接操作######################

//        //-----------------字节流复制文件到另一个文件-----------------------------
//        String copyLocation = "F:" + File.separator + "yl.txt";
//        String pasteLocation = "F:" + File.separator + "haha.txt";
//        File copyFile = new File(copyLocation);
//        File pasteFile = new File(pasteLocation);
//        try {
//            InputStream inputStream = new FileInputStream(copyFile);
//            OutputStream outputStream = new FileOutputStream(pasteFile);
//            int temp = 0;
//            while ((temp = inputStream.read()) != -1) {
//                outputStream.write(temp);
//            }
//            inputStream.close();
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        //---------------字节转化流InputStreamReader和OutputStreamWriter将字节流转成字符流
//        String location = "F:" + File.separator + "yl.txt";
//        File file = new File(location);
//        char[] chars = new char[(int) file.length()];
//        try {
//            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
//            inputStreamReader.read(chars);
//            System.out.println(new String(chars));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        //-------------用ByteArrayInputStream和ByteArrayOutputStream操作内存------------------
//        String original = "ABCDGASDF";
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(original.getBytes());
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        int temp = 0;
//        while ((temp = byteArrayInputStream.read()) != -1) {
//            byteArrayOutputStream.write(temp);
//        }
//        System.out.println(byteArrayOutputStream.toString());
//        try{
//            byteArrayInputStream.close();
//            byteArrayOutputStream.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }


//        //----------------PipeInputStream管道流用来线程间传输-----------------
//        SendRunable sendRunable = new SendRunable();
//        ReceiveRunable receiveRunable = new ReceiveRunable();
//        Thread sendThread = new Thread(sendRunable);
//        Thread receiveThread = new Thread(receiveRunable);
//        try {
//            sendRunable.getPipedOutputStream().connect(receiveRunable.getPipedInputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        sendThread.start();
//        receiveThread.start();

//        //-----------------打印流PrintStream------------------------
//        String location = "F:" + File.separator + "yl.txt";
//        File file = new File(location);
//        try {
//            PrintStream printStream = new PrintStream(new FileOutputStream(file));
//            String name="Rollen";
//            int age=20;
//            printStream.printf("姓名：%s. 年龄：%d.",name,age);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        //------------------字节流输出到系统输出流上-------------------
//        OutputStream outputStream = System.out;
//        try {
//            outputStream.write("hahaha".getBytes());
//            outputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        //---------------输入输出重定向-----------------------------
        //-----系统输出重定向-----
//        System.out.println("系统流重定向之前");
//        String location = "F:" + File.separator + "yl.txt";
//        File file = new File(location);
//        try {
//            System.setOut(new PrintStream(new FileOutputStream(file)));
//            System.out.println("系统重定向之后");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

////                //-----系统输入重定向------
//        String location = "F:" + File.separator + "yl.txt";
//        File file = new File(location);
//        byte[] bytes = new byte[1024];
//        try {
//            System.setIn(new FileInputStream(file));
//            System.in.read(bytes);
//            System.out.print(new String(bytes));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        //---------------BufferReader读键盘输入-------
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            String s = bufferedReader.readLine();
//            System.out.println(s);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        //--------------Scanner类读流内数据------------------
//        Scanner scanner = new Scanner(System.in);
//        int i = scanner.nextInt();
//        boolean b = scanner.nextBoolean();
//        System.out.println(i);
//        System.out.println(b);

//        //--------------Scanner类读取文件数据------------------
//        String location = "F:" + File.separator + "yl.txt";
//        File file = new File(location);
//        try {
//            Scanner scanner = new Scanner(file);
//            String s = scanner.next();
//            System.out.print(s);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        //------------DataOutputStream------------
//        String location = "F:" + File.separator + "yl.txt";
//        File file = new File(location);
//        byte[] bytes = {'1', '2'};
//        try {
//            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
//            dataOutputStream.write(bytes);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        //-----------DataInoutStream-------------------
//        String location = "F:" + File.separator + "yl.txt";
//        File file = new File(location);
//        byte[] bytes = new byte[1024];
//        try {
//            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
//            dataInputStream.read(bytes);
//            System.out.println(new String(bytes));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        //------------SequenceInputStream将两个输入流合并为一个流------------------
//        String yl = "F:" + File.separator + "yl.txt";
//        String lsy = "F:" + File.separator + "lsy.txt";
//        String test = "F:" + File.separator + "test.txt";
//        File ylFile = new File(yl);
//        File lsyFile = new File(lsy);
//        File testFile = new File(test);
//        try {
//            SequenceInputStream sequenceInputStream = new SequenceInputStream(new FileInputStream(ylFile), new FileInputStream(lsyFile));
//            OutputStream outputStream = new FileOutputStream(testFile);
//            int temp;
//            while ((temp = sequenceInputStream.read()) != -1) {
//                outputStream.write(temp);
//            }
//            sequenceInputStream.close();
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        //--------------ZipOutputStream将文件压缩成包---------
//        String test = "F:" + File.separator + "test.txt";
//        File testFile = new File(test);
//        String zip = "F:" + File.separator + "test.zip";
//        File zipFile = new File(zip);
//        try {
//            InputStream inputStream = new FileInputStream(testFile);
//            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
//            zipOutputStream.setComment("haha");
//            zipOutputStream.putNextEntry(new ZipEntry("test.txt"));
//            int temp;
//            while ((temp = inputStream.read()) != -1) {
//                zipOutputStream.write(temp);
//            }
//            inputStream.close();
//            zipOutputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        //----------------ZipOutputStream将多个文件压缩成包--------------
//        String demoPath = "F:" + File.separator + "txts";
//        File txtsPath = new File(demoPath);
//        File[] files = null;
//        String zip = "F:" + File.separator + "txts.zip";
//        File zipFile = new File(zip);
//        try {
//            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
//            zipOutputStream.setComment("要添加的注释");
//            if (txtsPath.isDirectory()) {
//                files = txtsPath.listFiles();
//            }
//            int temp;
//            for (File file : files) {
//                InputStream inputStream = new FileInputStream(file);
//                zipOutputStream.putNextEntry(new ZipEntry(txtsPath.getName() + File.separator + file.getName()));
//                while ((temp = inputStream.read()) != -1) {
//                    zipOutputStream.write(temp);
//                }
//                inputStream.close();
//            }
//            zipOutputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        //---------------ZipFile解压一个文件的压缩包--------
//        File file = new File("F:" + File.separator + "test.zip");
//        File unzipFile = new File("F:" + File.separator + "Unzip.txt");
//        try {
//            ZipFile zipFile = new ZipFile(file);
//            ZipEntry zipEntry = zipFile.getEntry("test.txt");
//            InputStream inputStream = zipFile.getInputStream(zipEntry);
//            OutputStream outputStream = new FileOutputStream(unzipFile);
//            int temp;
//            while ((temp = inputStream.read()) != -1) {
//                outputStream.write(temp);
//            }
//            inputStream.close();
//            outputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        //-------------ZipFile解压多个文件压缩包-------------
//        File file = new File("F:" + File.separator + "txts.zip");
//        try {
//            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
//            ZipFile zipFile = new ZipFile(file);
//            ZipEntry zipEntry;
//            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
//                File outFile = new File("F:" + File.separator + zipEntry.getName());
//                InputStream inputStream = zipFile.getInputStream(zipEntry);
//                if (!outFile.getParentFile().exists()) {
//                    outFile.getParentFile().mkdir();
//                }
//                if (!outFile.exists()) {
//                    outFile.createNewFile();
//                }
//                OutputStream outputStream = new FileOutputStream(outFile);
//                int temp;
//                while ((temp = inputStream.read()) != -1) {
//                    outputStream.write(temp);
//                }
//                inputStream.close();
//                outputStream.close();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        //-------------PushBackInputStream回退流--------------
//        String test = "hello,world";
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(test.getBytes());
//        PushbackInputStream pushbackInputStream = new PushbackInputStream(byteArrayInputStream);
//        int temp;
//        try {
//            while ((temp = pushbackInputStream.read()) != -1) {
//                if ((char) temp == ',') {
//                    pushbackInputStream.unread(',');
//                    System.out.print("回退的地方：" + (char) pushbackInputStream.read());
//                }
//                System.out.print((char) temp);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        //---------------获取系统默认编码------------------
//        System.out.print("系统编码：" + System.getProperty("file.encoding"));

//        //---------------编码不一致产生乱码------------------
//        String s = "覆盖";
//        try {
//            OutputStream outputStream = new FileOutputStream(new File("F:" + File.separator + "hello.txt"));
//            outputStream.write(s.getBytes("ISO8859-1"));
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        //-------------ObjectOutputSteam列化对象成txt-----------
//        Person person = new Person("AAA", 111);
//        try {
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("F:" + File.separator + "person.txt")));
//            objectOutputStream.writeObject(person);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        //-------------ObjectOutputSteam从txt反序列化对象-----------
//        try {
//            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("F:" + File.separator + "person.txt")));
//            Object object = objectInputStream.readObject();
//            System.out.print(object);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }
}

//class SendRunable implements Runnable {
//    PipedOutputStream pipedOutputStream = null;
//
//    public SendRunable() {
//        this.pipedOutputStream = new PipedOutputStream();
//    }
//
//    public PipedOutputStream getPipedOutputStream() {
//        return pipedOutputStream;
//    }
//
//    @Override
//    public void run() {
//        String test = "发斯蒂芬范德萨";
//        try {
//            pipedOutputStream.write(test.getBytes());
//            pipedOutputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//class ReceiveRunable implements Runnable {
//    PipedInputStream pipedInputStream = null;
//
//    public ReceiveRunable() {
//        this.pipedInputStream = new PipedInputStream();
//    }
//
//    public PipedInputStream getPipedInputStream() {
//        return pipedInputStream;
//    }
//
//    @Override
//    public void run() {
//        byte[] bytes = new byte[1024];
//        try {
//            pipedInputStream.read(bytes);
//            pipedInputStream.close();
//            System.out.println(new String(bytes));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}


//class Person implements Serializable {
//    private transient String name;
//    private int age;
//
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "姓名：" + this.name + " ； 年龄：" + this.age;
//    }
//}
