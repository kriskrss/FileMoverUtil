import java.io.File;

public class FileMover {

	public static void main(String[] args) {
		File parent = new File("/home/sai/Desktop/work/20_newsgroups");
		copyFromFolder(parent);
	}

	private static void copyFromFolder(File parent) {
		if (parent.isDirectory()) {
			File[] files = parent.listFiles();
			System.out.println(files.length);
			for (int i = 0; i < files.length; i++) {
				File current = files[i];
				if (current.isDirectory()) {
					copyFromFolder(current);
				} else {
					current.renameTo(new File("/home/sai/Desktop/work/20news/"
							+ current.getParentFile().getName()
							+ current.getName()));
				}
			}
		}
	}
}
