; ModuleID = 'builtin.c'
source_filename = "builtin.c"
target datalayout = "e-m:e-p:32:32-i64:64-n32-S128"
target triple = "riscv32-unknown-unknown-elf"

@.str = private unnamed_addr constant [3 x i8] c"%s\00", align 1
@.str.1 = private unnamed_addr constant [4 x i8] c"%s\0A\00", align 1
@.str.2 = private unnamed_addr constant [3 x i8] c"%d\00", align 1
@.str.3 = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1

; Function Attrs: mustprogress nofree nounwind willreturn
define dso_local noalias i8* @_malloc_(i32 noundef %0) local_unnamed_addr #0 {
  %2 = tail call i8* @malloc(i32 noundef %0) #10
  ret i8* %2
}

; Function Attrs: inaccessiblememonly mustprogress nofree nounwind willreturn
declare dso_local noalias noundef i8* @malloc(i32 noundef) local_unnamed_addr #1

; Function Attrs: nounwind
define dso_local void @print(i8* noundef %0) local_unnamed_addr #2 {
  %2 = tail call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i32 0, i32 0), i8* noundef %0) #11
  ret void
}

declare dso_local i32 @printf(i8* noundef, ...) local_unnamed_addr #3

; Function Attrs: nounwind
define dso_local void @println(i8* noundef %0) local_unnamed_addr #2 {
  %2 = tail call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([4 x i8], [4 x i8]* @.str.1, i32 0, i32 0), i8* noundef %0) #11
  ret void
}

; Function Attrs: nounwind
define dso_local void @printInt(i32 noundef %0) local_unnamed_addr #2 {
  %2 = tail call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([3 x i8], [3 x i8]* @.str.2, i32 0, i32 0), i32 noundef %0) #11
  ret void
}

; Function Attrs: nounwind
define dso_local void @printlnInt(i32 noundef %0) local_unnamed_addr #2 {
  %2 = tail call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds ([4 x i8], [4 x i8]* @.str.3, i32 0, i32 0), i32 noundef %0) #11
  ret void
}

; Function Attrs: nofree nounwind
define dso_local i32 @getInt() local_unnamed_addr #4 {
  %1 = alloca i32, align 4
  %2 = bitcast i32* %1 to i8*
  call void @llvm.lifetime.start.p0i8(i64 4, i8* nonnull %2) #12
  %3 = call i32 (i8*, ...) @scanf(i8* noundef getelementptr inbounds ([3 x i8], [3 x i8]* @.str.2, i32 0, i32 0), i32* noundef nonnull %1) #10
  %4 = load i32, i32* %1, align 4, !tbaa !4
  call void @llvm.lifetime.end.p0i8(i64 4, i8* nonnull %2) #12
  ret i32 %4
}

; Function Attrs: argmemonly mustprogress nofree nosync nounwind willreturn
declare void @llvm.lifetime.start.p0i8(i64 immarg, i8* nocapture) #5

; Function Attrs: nofree nounwind
declare dso_local noundef i32 @scanf(i8* nocapture noundef readonly, ...) local_unnamed_addr #6

; Function Attrs: argmemonly mustprogress nofree nosync nounwind willreturn
declare void @llvm.lifetime.end.p0i8(i64 immarg, i8* nocapture) #5

; Function Attrs: nofree nounwind
define dso_local i8* @getString() local_unnamed_addr #4 {
  %1 = tail call dereferenceable_or_null(256) i8* @malloc(i32 noundef 256) #10
  %2 = tail call i32 (i8*, ...) @scanf(i8* noundef getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i32 0, i32 0), i8* noundef %1) #10
  ret i8* %1
}

; Function Attrs: mustprogress nofree nounwind readonly willreturn
define dso_local i32 @string.length(i8* nocapture noundef readonly %0) local_unnamed_addr #7 {
  %2 = tail call i32 @strlen(i8* noundef nonnull dereferenceable(1) %0) #10
  ret i32 %2
}

; Function Attrs: argmemonly mustprogress nofree nounwind readonly willreturn
declare dso_local i32 @strlen(i8* nocapture noundef) local_unnamed_addr #8

; Function Attrs: mustprogress nofree norecurse nosync nounwind readonly willreturn
define dso_local i32 @string.ord(i8* nocapture noundef readonly %0, i32 noundef %1) local_unnamed_addr #9 {
  %3 = getelementptr inbounds i8, i8* %0, i32 %1
  %4 = load i8, i8* %3, align 1, !tbaa !8
  %5 = zext i8 %4 to i32
  ret i32 %5
}

; Function Attrs: mustprogress nofree nounwind readonly willreturn
define dso_local zeroext i1 @string.eq(i8* nocapture noundef readonly %0, i8* nocapture noundef readonly %1) local_unnamed_addr #7 {
  %3 = tail call i32 @strcmp(i8* noundef nonnull dereferenceable(1) %0, i8* noundef nonnull dereferenceable(1) %1) #10
  %4 = icmp eq i32 %3, 0
  ret i1 %4
}

; Function Attrs: argmemonly mustprogress nofree nounwind readonly willreturn
declare dso_local i32 @strcmp(i8* nocapture noundef, i8* nocapture noundef) local_unnamed_addr #8

; Function Attrs: mustprogress nofree nounwind readonly willreturn
define dso_local zeroext i1 @string.ne(i8* nocapture noundef readonly %0, i8* nocapture noundef readonly %1) local_unnamed_addr #7 {
  %3 = tail call i32 @strcmp(i8* noundef nonnull dereferenceable(1) %0, i8* noundef nonnull dereferenceable(1) %1) #10
  %4 = icmp ne i32 %3, 0
  ret i1 %4
}

; Function Attrs: mustprogress nofree nounwind readonly willreturn
define dso_local zeroext i1 @string.slt(i8* nocapture noundef readonly %0, i8* nocapture noundef readonly %1) local_unnamed_addr #7 {
  %3 = tail call i32 @strcmp(i8* noundef nonnull dereferenceable(1) %0, i8* noundef nonnull dereferenceable(1) %1) #10
  %4 = icmp slt i32 %3, 0
  ret i1 %4
}

; Function Attrs: mustprogress nofree nounwind readonly willreturn
define dso_local zeroext i1 @string.sgt(i8* nocapture noundef readonly %0, i8* nocapture noundef readonly %1) local_unnamed_addr #7 {
  %3 = tail call i32 @strcmp(i8* noundef nonnull dereferenceable(1) %0, i8* noundef nonnull dereferenceable(1) %1) #10
  %4 = icmp sgt i32 %3, 0
  ret i1 %4
}

; Function Attrs: mustprogress nofree nounwind readonly willreturn
define dso_local zeroext i1 @string.sge(i8* nocapture noundef readonly %0, i8* nocapture noundef readonly %1) local_unnamed_addr #7 {
  %3 = tail call i32 @strcmp(i8* noundef nonnull dereferenceable(1) %0, i8* noundef nonnull dereferenceable(1) %1) #10
  %4 = icmp sgt i32 %3, -1
  ret i1 %4
}

; Function Attrs: mustprogress nofree nounwind readonly willreturn
define dso_local zeroext i1 @string.sle(i8* nocapture noundef readonly %0, i8* nocapture noundef readonly %1) local_unnamed_addr #7 {
  %3 = tail call i32 @strcmp(i8* noundef nonnull dereferenceable(1) %0, i8* noundef nonnull dereferenceable(1) %1) #10
  %4 = icmp slt i32 %3, 1
  ret i1 %4
}

; Function Attrs: mustprogress nofree norecurse nosync nounwind readonly willreturn
define dso_local i32 @array.size(i32* nocapture noundef readonly %0) local_unnamed_addr #9 {
  %2 = getelementptr inbounds i32, i32* %0, i32 -1
  %3 = load i32, i32* %2, align 4, !tbaa !4
  ret i32 %3
}

; Function Attrs: nofree nounwind
define dso_local noalias i8* @toString(i32 noundef %0) local_unnamed_addr #4 {
  %2 = tail call dereferenceable_or_null(256) i8* @malloc(i32 noundef 256) #10
  %3 = tail call i32 (i8*, i8*, ...) @sprintf(i8* noundef nonnull dereferenceable(1) %2, i8* noundef nonnull dereferenceable(1) getelementptr inbounds ([3 x i8], [3 x i8]* @.str.2, i32 0, i32 0), i32 noundef %0) #10
  ret i8* %2
}

; Function Attrs: nofree nounwind
declare dso_local noundef i32 @sprintf(i8* noalias nocapture noundef writeonly, i8* nocapture noundef readonly, ...) local_unnamed_addr #6

; Function Attrs: nofree nounwind
define dso_local noalias i8* @string.add(i8* nocapture noundef readonly %0, i8* nocapture noundef readonly %1) local_unnamed_addr #4 {
  %3 = tail call dereferenceable_or_null(512) i8* @malloc(i32 noundef 512) #10
  %4 = tail call i32 @strlen(i8* noundef nonnull dereferenceable(1) %0) #10
  %5 = icmp eq i32 %4, 0
  br i1 %5, label %6, label %9

6:                                                ; preds = %9, %2
  %7 = tail call i32 @strlen(i8* noundef nonnull dereferenceable(1) %1) #10
  %8 = icmp eq i32 %7, 0
  br i1 %8, label %16, label %17

9:                                                ; preds = %2, %9
  %10 = phi i32 [ %14, %9 ], [ 0, %2 ]
  %11 = getelementptr inbounds i8, i8* %0, i32 %10
  %12 = load i8, i8* %11, align 1, !tbaa !8
  %13 = getelementptr inbounds i8, i8* %3, i32 %10
  store i8 %12, i8* %13, align 1, !tbaa !8
  %14 = add nuw nsw i32 %10, 1
  %15 = icmp eq i32 %14, %4
  br i1 %15, label %6, label %9, !llvm.loop !9

16:                                               ; preds = %17, %6
  ret i8* %3

17:                                               ; preds = %6, %17
  %18 = phi i32 [ %23, %17 ], [ 0, %6 ]
  %19 = getelementptr inbounds i8, i8* %1, i32 %18
  %20 = load i8, i8* %19, align 1, !tbaa !8
  %21 = add i32 %18, %4
  %22 = getelementptr inbounds i8, i8* %3, i32 %21
  store i8 %20, i8* %22, align 1, !tbaa !8
  %23 = add nuw nsw i32 %18, 1
  %24 = icmp eq i32 %23, %7
  br i1 %24, label %16, label %17, !llvm.loop !11
}

; Function Attrs: nofree nounwind
define dso_local noalias i8* @string.substring(i8* nocapture noundef readonly %0, i32 noundef %1, i32 noundef %2) local_unnamed_addr #4 {
  %4 = tail call dereferenceable_or_null(256) i8* @malloc(i32 noundef 256) #10
  %5 = icmp sgt i32 %2, %1
  br i1 %5, label %9, label %6

6:                                                ; preds = %9, %3
  %7 = sub nsw i32 %2, %1
  %8 = getelementptr inbounds i8, i8* %4, i32 %7
  store i8 0, i8* %8, align 1, !tbaa !8
  ret i8* %4

9:                                                ; preds = %3, %9
  %10 = phi i32 [ %15, %9 ], [ %1, %3 ]
  %11 = getelementptr inbounds i8, i8* %0, i32 %10
  %12 = load i8, i8* %11, align 1, !tbaa !8
  %13 = sub nsw i32 %10, %1
  %14 = getelementptr inbounds i8, i8* %4, i32 %13
  store i8 %12, i8* %14, align 1, !tbaa !8
  %15 = add nsw i32 %10, 1
  %16 = icmp eq i32 %15, %2
  br i1 %16, label %6, label %9, !llvm.loop !12
}

; Function Attrs: nofree nounwind
define dso_local i32 @string.parseInt(i8* nocapture noundef readonly %0) local_unnamed_addr #4 {
  %2 = alloca i32, align 4
  %3 = bitcast i32* %2 to i8*
  call void @llvm.lifetime.start.p0i8(i64 4, i8* nonnull %3) #12
  %4 = call i32 (i8*, i8*, ...) @sscanf(i8* noundef %0, i8* noundef getelementptr inbounds ([3 x i8], [3 x i8]* @.str.2, i32 0, i32 0), i32* noundef nonnull %2) #10
  %5 = load i32, i32* %2, align 4, !tbaa !4
  call void @llvm.lifetime.end.p0i8(i64 4, i8* nonnull %3) #12
  ret i32 %5
}

; Function Attrs: nofree nounwind
declare dso_local noundef i32 @sscanf(i8* nocapture noundef readonly, i8* nocapture noundef readonly, ...) local_unnamed_addr #6

attributes #0 = { mustprogress nofree nounwind willreturn "frame-pointer"="none" "min-legal-vector-width"="0" "no-builtin-memcpy" "no-builtin-printf" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-features"="+a,+c,+m" }
attributes #1 = { inaccessiblememonly mustprogress nofree nounwind willreturn "frame-pointer"="none" "no-builtin-memcpy" "no-builtin-printf" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-features"="+a,+c,+m" }
attributes #2 = { nounwind "frame-pointer"="none" "min-legal-vector-width"="0" "no-builtin-memcpy" "no-builtin-printf" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-features"="+a,+c,+m" }
attributes #3 = { "frame-pointer"="none" "no-builtin-memcpy" "no-builtin-printf" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-features"="+a,+c,+m" }
attributes #4 = { nofree nounwind "frame-pointer"="none" "min-legal-vector-width"="0" "no-builtin-memcpy" "no-builtin-printf" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-features"="+a,+c,+m" }
attributes #5 = { argmemonly mustprogress nofree nosync nounwind willreturn }
attributes #6 = { nofree nounwind "frame-pointer"="none" "no-builtin-memcpy" "no-builtin-printf" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-features"="+a,+c,+m" }
attributes #7 = { mustprogress nofree nounwind readonly willreturn "frame-pointer"="none" "min-legal-vector-width"="0" "no-builtin-memcpy" "no-builtin-printf" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-features"="+a,+c,+m" }
attributes #8 = { argmemonly mustprogress nofree nounwind readonly willreturn "frame-pointer"="none" "no-builtin-memcpy" "no-builtin-printf" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-features"="+a,+c,+m" }
attributes #9 = { mustprogress nofree norecurse nosync nounwind readonly willreturn "frame-pointer"="none" "min-legal-vector-width"="0" "no-builtin-memcpy" "no-builtin-printf" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-features"="+a,+c,+m" }
attributes #10 = { "no-builtin-memcpy" "no-builtin-printf" }
attributes #11 = { nobuiltin nounwind "no-builtin-memcpy" "no-builtin-printf" }
attributes #12 = { nounwind }

!llvm.module.flags = !{!0, !1, !2}
!llvm.ident = !{!3}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{i32 1, !"target-abi", !"ilp32"}
!2 = !{i32 1, !"SmallDataLimit", i32 8}
!3 = !{!"Ubuntu clang version 14.0.0-1ubuntu1.1"}
!4 = !{!5, !5, i64 0}
!5 = !{!"int", !6, i64 0}
!6 = !{!"omnipotent char", !7, i64 0}
!7 = !{!"Simple C/C++ TBAA"}
!8 = !{!6, !6, i64 0}
!9 = distinct !{!9, !10}
!10 = !{!"llvm.loop.mustprogress"}
!11 = distinct !{!11, !10}
!12 = distinct !{!12, !10}
