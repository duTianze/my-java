package com.dutianze.designpattern.behavioral.visitor;

import com.dutianze.designpattern.behavioral.visitor.unit.impl.Commander;
import com.dutianze.designpattern.behavioral.visitor.unit.impl.Sergeant;
import com.dutianze.designpattern.behavioral.visitor.unit.impl.Soldier;

/**
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="https://github.com/apache/wicket">Apache Wicket</a> component tree, see <a href="https://github.com/apache/wicket/blob/b60ec64d0b50a611a9549809c9ab216f0ffa3ae3/wicket-core/src/main/java/org/apache/wicket/MarkupContainer.java">MarkupContainer</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/AnnotationValue.html">javax.lang.model.element.AnnotationValue</a> and <a href="http://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/AnnotationValueVisitor.html">AnnotationValueVisitor</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/Element.html">javax.lang.model.element.Element</a> and <a href="http://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/ElementVisitor.html">Element Visitor</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/nio/file/FileVisitor.html">java.nio.file.FileVisitor</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/14
 */
public interface UnitVisitor {

    void visitSoldier(Soldier soldier);

    void visitSergeant(Sergeant sergeant);

    void visitCommander(Commander commander);
}
