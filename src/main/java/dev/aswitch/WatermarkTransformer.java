package dev.aswitch;

import dev.mdma.qprotect.api.jar.JarFile;
import dev.mdma.qprotect.api.transformer.ClassTransformer;
import dev.mdma.qprotect.api.transformer.TransformException;
import org.objectweb.asm.tree.ClassNode;

import java.util.UUID;

public class WatermarkTransformer extends ClassTransformer {


    public WatermarkTransformer() {
        super("Simple Watermark", "Added your custom watermark to {} class(es)!");
    }

    public static String WATERMARK_TEXT = "A simple watermark by aSwitch";

    @Override
    public boolean runOnClass(String s, ClassNode classNode, JarFile jarFile) throws TransformException {
        classNode.visitField(ACC_PUBLIC + ACC_STATIC, UUID.randomUUID().toString().replace("-","_"), "Ljava/lang/String;", null, WATERMARK_TEXT);
        counter.incrementAndGet();
        return false;
    }

}
