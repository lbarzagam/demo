package demo.application.backend.infra.exceptions;

public final class DomainEntityNotExistsException extends RuntimeException {

    public DomainEntityNotExistsException(Class<?> entityClass, Object entityId) {
        super(String.format("No se encontró un registro para la entidad <%s> con id <%s>", entityClass.getSimpleName(), entityId));
    }
}
