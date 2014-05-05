package bynull.hadoop;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.hdfs.MiniDFSCluster;
import org.junit.Test;

/**
 * Created by null on 06.05.14.
 */
public class HadoopTest {

    @Test
    public void testMega() throws IOException {
        File baseDir = new File("./target/hdfs/test").getAbsoluteFile();
        FileUtil.fullyDelete(baseDir);
        Configuration conf = new Configuration();
        conf.set(MiniDFSCluster.HDFS_MINIDFS_BASEDIR, baseDir.getAbsolutePath());
        MiniDFSCluster.Builder builder = new MiniDFSCluster.Builder(conf);
        MiniDFSCluster hdfsCluster = builder.build();
        String hdfsURI = "hdfs://localhost:"+ hdfsCluster.getNameNodePort() + "/";
    }
}
