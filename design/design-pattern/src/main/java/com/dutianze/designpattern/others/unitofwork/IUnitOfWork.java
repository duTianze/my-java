package com.dutianze.designpattern.others.unitofwork;

/**
 * <h2 id="tutorials">Tutorials</h2>
 * <ul>
 * <li><a href="https://ducmanhphan.github.io/2019-08-20-Unit-of-Work-pattern">Unit-of-Work-pattern</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/19
 */
public interface IUnitOfWork<T> {

  void registerNew(T entity);

  void registerModified(T entity);

  void registerDeleted(T entity);

  void commit();
}