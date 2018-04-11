package net.jqsoft.system.utils;

/**
 * @desc File工具类，包括处理文件大小等功能
 * @author fangfq
 *	@date 2018年4月8日  
 */
public class FileUtils {
		/**
		 * 文件尺寸单位 KB
		 */
		 public static final String FILE_SIZE_TYPE_KBB = "KB";
		 /**
		  * 文件尺寸单位 Kb
		  */
		 public static final String FILE_SIZE_TYPE_KB = "Kb";
		 /**
		  * 文件尺寸单位 MB
		  */
		 public static final String FILE_SIZE_TYPE_MB = "MB";
		 /**
		  * 文件尺寸单位 Mb
		  */
		 public static final String FILE_SIZE_TYPE_MBB = "Mb";
		 /**
		  * 文件尺寸单位 GB
		  */
		 public static final  String FILE_SIZE_TYPE_GB = 	"GB";
		 
		 /**
		 * @desc<p>将long型文件大小换为指定单位的文件大小</p>
		 * @author fangfq
		 *	@date 2018年4月8日
		 * @param fileSize 文件大小 long型
		 * @param fileSizeType 文件大小单位类型 可在本类静态字段中指定
		 * @return  String
		 */
		public static long getFileSizeTypeKb(long fileSize,String fileSizeType) {
			//局部变量，需要初始化
			long size = 0;
			switch (fileSizeType) {
				case FILE_SIZE_TYPE_KB:
					size = handleKB(fileSize);
					break;
				case FILE_SIZE_TYPE_KBB:
					size = handleKBB(fileSize);
					break;
				case FILE_SIZE_TYPE_MB:
					size = handleMB(fileSize);
					break;
				case FILE_SIZE_TYPE_MBB:
					size = handleMBB(fileSize);
					break;
				case FILE_SIZE_TYPE_GB:
					size = handleGB(fileSize);
					break;
				default:
					break;
			}
			return size;
		}
		
		private static long handleGB(long fileSize) {
			return fileSize/8/1024/1024/1024;
		}

		private static long handleMB(long fileSize) {
			return fileSize/8/1024/1024;
		}
		
		private static long handleMBB(long fileSize) {
			return fileSize/1024/1024;
		}

		private static long handleKBB(long fileSize) {
			return fileSize/8/1024;
		}

		protected static long handleKB(long fileSize) {
			return fileSize/1024;
		}
	
}
