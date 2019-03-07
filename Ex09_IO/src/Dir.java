import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dir {
	private static Date date;
	public static void main(String[] args) {
		checkCommand(args);

	}

	static void checkCommand(String[] args) {
		File file = null;
		if (args.length != 1 && args.length != 2 && args.length != 3 && args.length != 4) {
			howToUse();
		}
		file = new File(args[1]);
		if (args.length != 1 && (!file.exists() || !file.isDirectory())) {
			System.out.println("Check [file] or path");
			System.exit(0);
		}
		try {
			switch (args[0]) {
			case "dir":
				dir(file);
				break;
			case "mkdir":
				mkdir(file, args);
				break;
			case "rename":
				rename(file, args);
				break;
			case "pwd":
				pwd();
				break;
			case "del" :
				del(file, args);
				break;
			case "type" :
				type(file, args);
				break;
			default:
				howToUse();
				break;
			}
		} catch (Exception ArrayIndexOutOfBoundsException) {
			howToUse();
		}
	}

	static void howToUse() {
		System.out.println("\n How to use");
		System.out.println(" \"[fileName.java] pwd \"  <== Press Enter Key\n");
		System.out.println(" \"[fileName.java] dir [path] \"  <== Press Enter Key\n");
		System.out.println(" \"[fileName.java] mkdir [path] [new DirectoryName] \"  <== Press Enter Key\n");
		System.out.println(" \"[fileName.java] rename [path] [old Name] [New Name]  \"  <== Press Enter Key\n");
		System.out.println(" \"[fileName.java] del [path] [old Name]  \"  <== Press Enter Key\n");
		System.out.println(" \"[fileName.java] type [path] [old Name]  \"  <== Press Enter Key\n");
		System.exit(0);
	}

	static void dir(File file) {
		File[] fileArr = file.listFiles();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd a HH-mm ");
		String attribute = "";
		String size = "";

		for (int i = 0; i < fileArr.length; i++) {
			long lastModified = fileArr[i].lastModified(); // 마지막 수정일
			if (fileArr[i].isDirectory()) {
				attribute = "<DIR>";
			} else {
				attribute = "-";
				attribute += fileArr[i].canRead() ? "r" : "";
				attribute += fileArr[i].canWrite() ? "w" : "";
				attribute += fileArr[i].isHidden() ? "h" : "";
			}
			String name = fileArr[i].getName();
			System.out.printf("%s %-5s %s \n", simpledateformat.format(new Date(lastModified)), attribute, name);
		}
	}

	static void mkdir(File file, String[] args) {
		String path = "";
		path = file + "/" + args[2];
		File newfile = new File(path);
		if (newfile.exists()) {
			System.out.println("이미 존재하는 디렉토리 입니다.");
			System.exit(0);
		} else {
			newfile.mkdir();
			System.out.println("[" + args[2] + "] 폴더가 생성되었습니다.");
		}

	}

	static void rename(File file, String[] args) {

		String oldPath = "";
		String newPath = "";
		oldPath = file + "/" + args[2];
		newPath = file + "/" + args[3];
		File oldFile = new File(oldPath);
		File newFile = new File(newPath);

		if (oldFile.exists() && !newFile.exists() && (oldFile != newFile)) {
			oldFile.renameTo(newFile);
		} else {
			System.out.println("동일한 파일명이 이미 존재하거나, 변경하고자 하는 디렉토리가 없습니다.");
		}

	}

	static void pwd() {
		System.out.println(System.getProperty("user.dir"));
	}

	static void del(File file, String[] args) {
		String oldpath = "";
		oldpath = file + "\\" + args[2];
		File oldFile = new File(oldpath);
		if (oldFile.exists()) {
			oldFile.delete();
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}
	static void type(File file , String[] args) throws IOException {
		 FileReader fr = null;
         BufferedReader br = null;

         String path = "";
         path = file + "\\" + args[2];
         File newfile = new File(path);

         fr = new FileReader(newfile);
         br = new BufferedReader(fr);

         String line = "";
         for(int i=0; (line = br.readLine()) != null; i++) {
             System.out.println(line);
         }

         br.close();
         fr.close();

     }
	}

