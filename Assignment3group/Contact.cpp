#include "Contact.h"
#include <algorithm>

Contact::Contact(std::string *name, int age) {};

void Contact::addFriend(Contact *newFriend) {
    m_friends.push_back(newFriend);
}

void Contact::removeFriend(std::string_view friendName) {
//    auto i =  std::find_if(m_friends.begin(), m_friends.end(), [&friendName] (Contact& object) {
//        return *object.m_name == friendName; });
    for(int i = 0; i < m_friends.size(); i++) {
        if(*m_friends.at(i)->m_name == friendName) {
            m_friends.erase(m_friends.begin() + i);
        }
    }

}

