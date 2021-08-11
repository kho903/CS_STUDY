package chap13;

import java.util.Comparator;

public class Member implements /* Comparable<Member> */ Comparator<Member> {
    private int memberId;       // 회원 아이디
    private String memberName;  // 회원 이름

    public Member() { }

    public Member(int memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                '}';
    }

    @Override
    public int compare(Member member1, Member member2) {
        return (member1.memberId - member2.memberId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member) {
            Member member = (Member) obj;
            if (this.memberId == member.memberId) {
                return true;
            } else return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return memberId;
    }

//    @Override // Comparable
//    public int compareTo(Member member) {
//        return (this.memberId - member.memberId); // 오름차순 / -1을 곱하면 내림차순
//    }
}
