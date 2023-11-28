#include <string>


#ifndef ASSIGNMENT3_CONTACT_H
#define ASSIGNMENT3_CONTACT_H

class Contact {
private:
    std::string* m_name { nullptr };
    int m_age {};
    std::vector<Contact*> m_friends {};
    Contact(std::string* name, int age);
    void addFriend(Contact* newFriend);
    void removeFriend(std::string_view friendName);
    friend class ContactUtility;
};


#endif //ASSIGNMENT3_CONTACT_H
