package design_structure_assembly;

/**
 * 组合模式
 * 在文件系统中，有文件夹概念，文件夹既可以放入文件又可以放入文件夹，但是文件中却不能放入任何东西，文件夹和文件组成了一种递归结构
 * 缺点：如果是某个特殊条件，需要对他做特殊操作
 */
public class test {

    public static void main(String[] args) {
        //c盘
        Folder folder=new Folder("C:");
        Folder folder1=new Folder("蓝桥杯");
        folder.add(folder1);
        File file2=new File("3.txt");
        folder1.add(file2);
        //文件
        File file=new File("1.txt");
        File file1=new File("2.txt");
        folder.add(file);
        folder.add(file1);

        Folder folder2=new Folder("大数据");
        Folder folder3=new Folder("Linux");
        folder2.add(folder3);
        folder3.add(file1);
        File file4=new File("4.txt");
        folder2.add(file4);
        folder1.add(file1);
        folder1.add(folder2);
        getAll(folder,0);


    }

    public static void getAll(IFile rootFolder,int deep){
        //这个for循环可以理解为文件夹的层数
        for (int j=0;j<deep;j++){
            System.out.print("--");
        }
        rootFolder.display(); //c盘
        for (int i=0;i<rootFolder.getChildren().size();i++){
            if (rootFolder.getChildren().get(i) instanceof Folder){
                getAll(rootFolder.getChildren().get(i),deep+1);
            }else {
                for (int s=0;s<=deep;s++){ //这个for循环指的是当前文件夹下面的文件，这里可以看到s<=deep，比文件夹多了一层
                    System.out.print("--");
                }
                rootFolder.getChildren().get(i).display();
            }
        }
    }
}
