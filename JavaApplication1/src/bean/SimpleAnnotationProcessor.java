/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bean.WritingStyle;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic;

/**
 *
 * @author jabir.amirkhanli
 */
@SupportedAnnotationTypes("bean.WritingStyle")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class SimpleAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv) {
        
        System.out.println("processr is executed");
        for(final Element element : roundEnv.getElementsAnnotatedWith(WritingStyle.class))         
                {
                  String varName = element.getSimpleName().toString();
                    if (!varName.startsWith("teacher")) {
                        processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Must start with teacher");
                    }
                  System.out.println("element.getSimpleName() = " + element.getSimpleName());  
                  System.out.println("element" + element.getClass().getName() );
//                    if(element instanceof TypeElement)
//                    {
//                        final TypeElement typeElement = (TypeElement) element;
//                        
//                        for(final Element eclosedElement : typeElement.getEnclosedElements())
//                        {
//                            if(eclosedElement instanceof VariableElement )
//                            {
//                                final VariableElement variableElement = (VariableElement) eclosedElement;
//                                
////                                if (!variableElement.getModifiers().contains(Modifier.FINAL))
//                                 if (variableElement.getConstantValue()==null)
//                                {
//                                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "bosh lmasin");
//                                }
//                            }
//                                
//                        }
//                    }
                    
                    return true;
                }
           return false;
    }
    
}

