package site.junggam.procurement_system.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1861986828L;

    public static final QUser user = new QUser("user");

    public final DateTimePath<java.time.LocalDateTime> userBirth = createDateTime("userBirth", java.time.LocalDateTime.class);

    public final StringPath userDept = createString("userDept");

    public final StringPath userEmail = createString("userEmail");

    public final StringPath userId = createString("userId");

    public final StringPath userImageFile = createString("userImageFile");

    public final StringPath userName = createString("userName");

    public final NumberPath<Long> userNumber = createNumber("userNumber", Long.class);

    public final StringPath userPw = createString("userPw");

    public final StringPath userRank = createString("userRank");

    public final StringPath userStatus = createString("userStatus");

    public final StringPath userTeam = createString("userTeam");

    public final StringPath userTel = createString("userTel");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

