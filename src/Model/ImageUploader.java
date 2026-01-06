package Model;

import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.awt.Image;

public class ImageUploader {

    private static final String IMAGES_DIR = "src/images/";  // This makes files appear in NetBeans

    public static String selectAndUploadImage(java.awt.Component parent) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select Product Image");
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
            "Images", "jpg", "jpeg", "png", "gif", "bmp"));

        if (chooser.showOpenDialog(parent) != JFileChooser.APPROVE_OPTION) {
            return null;
        }

        File sourceFile = chooser.getSelectedFile();
        String newFileName = copyToImagesFolder(sourceFile);

        if (newFileName != null) {
            JOptionPane.showMessageDialog(parent, "Image uploaded successfully!");
            return newFileName;  // Return ONLY filename, e.g., product_1704123456789.jpg
        }
        return null;
    }

    private static String copyToImagesFolder(File sourceFile) {
        try {
            File dir = new File(IMAGES_DIR);
            if (!dir.exists()) dir.mkdirs();

            String ext = "";
            String name = sourceFile.getName();
            int dot = name.lastIndexOf('.');
            if (dot > 0) ext = name.substring(dot);

            String newName = "product_" + System.currentTimeMillis() + ext;

            Files.copy(sourceFile.toPath(), new File(IMAGES_DIR + newName).toPath(),
                       StandardCopyOption.REPLACE_EXISTING);

            return newName;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to save image.");
            return null;
        }
    }

    // Load preview from classpath
    public static ImageIcon getPreviewIcon(String fileName, int w, int h) {
        if (fileName == null || fileName.isEmpty()) return null;

        java.net.URL url = ImageUploader.class.getResource("/images/" + fileName);
        if (url != null) {
            ImageIcon icon = new ImageIcon(url);
            Image img = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        }
        return null;
    }

    // Delete physical file
    public static boolean deleteImage(String fileName) {
        if (fileName == null || fileName.isEmpty()) return true;
        try {
            File file = new File(IMAGES_DIR + fileName);
            if (file.exists()) {
                return file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}